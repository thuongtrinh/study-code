import { PureComponent } from "react";

class ProductList extends PureComponent {

  render() {
    const { products } = this.props;
    return (
      <ul>
        {products.map((product) => (
          <li key={product.id}>{product.name}</li>
        ))}
      </ul>
    );
  }
}

export default ProductList;
