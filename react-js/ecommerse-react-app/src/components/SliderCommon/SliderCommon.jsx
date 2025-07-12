import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { MdOutlineArrowBackIosNew } from 'react-icons/md';
import { MdArrowForwardIos } from 'react-icons/md';
import './styles.css';
import ProductItem from '@components/ProductItem/ProductItem';

function SliderCommon({ data, isProductItem = false, showItem = 1 }) {
    var settings = {
        dots: false,
        infinite: true,
        speed: 500,
        slidesToShow: showItem,
        slidesToScroll: 1,
        nextArrow: <MdArrowForwardIos />,
        prevArrow: <MdOutlineArrowBackIosNew />
    };

    return (
        <Slider {...settings}>
            {data.map((item, index) => {
                const src = item?.images ? item?.images[0] : item.image;

                return (
                    <div>
                        {isProductItem ? (
                            <ProductItem
                                src={src}
                                prevSrc={src}
                                name={item.name}
                                price={item.price}
                                details={item}
                                isHomepage={false}
                                slideItem
                            />
                        ) : (
                            <img src={item} key={index} alt='test' />
                        )}
                    </div>
                );
            })}
        </Slider>
    );
}

export default SliderCommon;
