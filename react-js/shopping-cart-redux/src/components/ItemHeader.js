import { Component } from "react";

class ItemHeader extends Component {
    render() {
        return (
            <header>
                <div className="nav container">
                    <a href="{#}" className="logo">Online Store</a>
                    <i className="bx bx-shopping-bag" id="cart-icon"></i>
                </div>
            </header>
        );
    }
}

export default ItemHeader;