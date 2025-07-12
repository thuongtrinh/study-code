import BoxIcon from './BoxIcon/BoxIcon';
import Menu from './Menu/Menu';
import { dataBoxIcon, dataMenu } from './constants';
import styles from './styles.module.scss';
import Logo from '@icons/images/Logo-retina.png';
import { TfiReload } from 'react-icons/tfi';
import { BsHeart } from 'react-icons/bs';
import { PiShoppingCart } from 'react-icons/pi';
import useScrollHandling from '@/hooks/useScrollHandling';
import { useEffect } from 'react';
import { useState } from 'react';
import classNames from 'classnames';
import { useContext } from 'react';
import { SideBarContext } from '@/contexts/SideBarProvider';
import { StoreUserContext } from '@/contexts/StoreUserProvider';

function MyHeader() {
  const {
    containerBoxIcon,
    containerMenu,
    containerHeader,
    containerBox,
    container,
    fixedHeader,
    topHeader,
    boxCart,
    quantity,
  } = styles;

  const { scrollPosition } = useScrollHandling();
  const [fixedPosition, setFixedPosition] = useState(false);
  const {
    setIsOpen,
    setType,
    listProductCart,
    userId,
    handleGetListProductsCart,
  } = useContext(SideBarContext);
  const { userInfo } = useContext(StoreUserContext);

  const handleOpenSideBar = (type) => {
    setIsOpen(true);
    setType(type);
  };

  const handleOpenCartSideBar = () => {
    handleGetListProductsCart(userId, 'cart');
    handleOpenSideBar('cart');
  };

  const totalItemCart = listProductCart.length
    ? listProductCart.reduce((acc, item) => {
        return (acc += item.quantity);
      }, 0)
    : 0;

  useEffect(() => {
    setFixedPosition(scrollPosition > 80);
  }, [scrollPosition]);

  return (
    <div
      className={classNames(container, topHeader, {
        [fixedHeader]: fixedPosition,
      })}
    >
      <div className={containerHeader}>
        <div className={containerBox}>
          <div className={containerBoxIcon}>
            {dataBoxIcon.map((item, index) => {
              return <BoxIcon type={item.type} href={item.href} key={index} />;
            })}
          </div>
          <div className={containerMenu}>
            {dataMenu.slice(0, 3).map((item, index) => {
              return <Menu content={item.content} href={item.href} key={index} />;
            })}
          </div>
        </div>
        <div>
          <img
            src={Logo}
            alt="Logo"
            style={{
              width: '153px',
              height: '53px',
            }}
          />
        </div>
        <div className={containerBox}>
          <div className={containerMenu}>
            {dataMenu.slice(3, dataMenu.length).map((item, index) => {
              return <Menu content={item.content} href={item.href} key={index}/>;
            })}
          </div>

          <div className={containerBoxIcon}>
            <TfiReload
              style={{
                fontSize: '20px',
              }}
              onClick={() => handleOpenSideBar('compare')}
            />
            <BsHeart
              style={{
                fontSize: '20px',
              }}
              onClick={() => handleOpenSideBar('wishlist')}
            />
            <div className={boxCart}>
              <PiShoppingCart
                style={{
                  fontSize: '25px',
                }}
                onClick={() => handleOpenCartSideBar()}
              />

              <div className={quantity}>
                {totalItemCart || userInfo?.amountCart || 0}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default MyHeader;
