package com.txt.eshopperboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.txt.eshopperboot.dto.Address;
import com.txt.eshopperboot.dto.Cart;
import com.txt.eshopperboot.dto.Product;
import com.txt.eshopperboot.dto.User;
import com.txt.eshopperboot.repositories.AddressRepository;
import com.txt.eshopperboot.repositories.BrandRepository;
import com.txt.eshopperboot.repositories.CartRepository;
import com.txt.eshopperboot.repositories.CategoryRepository;
import com.txt.eshopperboot.repositories.ProductRepository;
import com.txt.eshopperboot.repositories.UserRepository;
import com.txt.eshopperboot.service.CommonService;
import com.txt.eshopperboot.service.SecurityUtils;
import com.txt.eshopperboot.service.UserService;
import com.txt.eshopperboot.util.MyUserDetail;
import com.txt.eshopperboot.validator.AddressValidator;
import com.txt.eshopperboot.validator.UserValidator;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CartRepository cartRepository;
    private static final String BLANK = "";
    private static final int COUNT_START = 1;

    @RequestMapping(value = {"/home", "/", "/index"})
    public String home(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/contact-us")
    public String contact(Model model) {
        return "contact-us";
    }

    @RequestMapping(value = "/notfound")
    public String notfound(Model model) {
        return "404";
    }

    @InitBinder("user")
    protected void initUserBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @InitBinder("address")
    protected void initAddressBinder(WebDataBinder binder) {
        binder.setValidator(new AddressValidator());
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model) {
        List<Cart> listCart = new ArrayList<>();
        MyUserDetail myUserDetail = SecurityUtils.getMyUserDetail();
        listCart = cartRepository.findByUserId(myUserDetail.getId());
        for (Cart cart : listCart) {
            System.out.println("Product id: " + cart.getProduct().getName());
            System.out.println("Product id: " + cart.getProduct().getImageURL());
        }

        model.addAttribute("carts", listCart);

        return "cart";
    }

    @RequestMapping(value = "/add-to-cart/{productId}", method = RequestMethod.POST)
    public String cart(@Valid @ModelAttribute("address") Address address, BindingResult resultAddress, @Valid @ModelAttribute("user") User user, BindingResult resultUser, Model model, @PathVariable int productId) {

        Optional<Product> productOp = productRepository.findById(productId);
        Product product = new Product();
        if (productOp.isPresent()) {
            product = productOp.get();
        }
        model.addAttribute("product", product);

        // Check error of form submit
        if (resultAddress.hasErrors() || resultUser.hasErrors()) {
            model.addAttribute("countryList", commonService.getListContry());
            model.addAttribute("cityList", commonService.getListCity());
            return "checkout";
        }

        user.setRole(SecurityUtils.getMyUserDetail().getAuthorities().toArray()[0].toString());

        userRepository.updateJPQL(user.getUsername(), user.getFirstName(), user.getLastName(), user.getPhone(), BLANK.equals(user.getMiddleName()) ? null : user.getMiddleName(), BLANK.equals(user.getMobilePhone()) ? null : user.getMobilePhone(), BLANK.equals(user.getFax()) ? null : user.getFax());

        address.setUser(user);
        addressRepository.save(address);

        Cart cart = cartRepository.findByUserIdAndProductId(user.getId(), productId);
        boolean update_cart = false;

        if (cart != null) {
            cartRepository.updateCart(product.getUnitPrice(), user.getId(), product.getId());
            update_cart = true;
        }

        cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setBuyingPrice(product.getUnitPrice());
        cart.setGrandTotal(COUNT_START);
        cart.setProductCount(COUNT_START);
        cart.setGrandTotal(product.getUnitPrice());

        if (!update_cart) {
            cartRepository.save(cart);
        }

        return "cart";
    }

    @RequestMapping(value = "/product-details")
    public String productDetails(Model model) {
        return "product-details";
    }

    @RequestMapping(value = "/checkout/{productId}/product", method = RequestMethod.GET)
    public String checkout(Model model, @PathVariable int productId) {
        Optional<Product> productOp = productRepository.findById(productId);
        Product product = new Product();
        if (productOp.isPresent()) {
            product = productOp.get();
        }
        model.addAttribute("product", product);

        User user = new User();
        MyUserDetail myUserDetail = SecurityUtils.getMyUserDetail();
        BeanUtils.copyProperties(myUserDetail, user);

        model.addAttribute("user", user);
        model.addAttribute("address", new Address());

        model.addAttribute("countryList", commonService.getListContry());
        model.addAttribute("cityList", commonService.getListCity());

        return "checkout";
    }

    @RequestMapping(value = "/shop")
    public String shop(Model model) {
        return "shop";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(name = "logout", required = false) String logout, Model model) {
        if (logout != null) {
            model.addAttribute("logout", "You has successfully logged out!");
        } else {
            User user = new User();
            user.setEnable(true);
            model.addAttribute("user", user);
        }

        return "login";
    }

	/*@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user, BindingResult result) {
		System.out.println("Start Sign up account");
		if (result.hasErrors()) {
			System.out.println("Sign up account has error" + result.toString());
			return "login";
		}
		System.out.println("Sign up account");

		userService.saveUser(user);
		return "index";
	}*/

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        // first we are going to fetch the authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/access-denied")
    public String accessDenied(Model model) {
        model.addAttribute("title", "403 - Access Denied");
        model.addAttribute("errorTitle", "Aha! Caught You.");
        model.addAttribute("errorDescription", "You are not authorized to view this page!");
        return "error";
    }

}
