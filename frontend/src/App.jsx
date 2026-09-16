import { useEffect, useState } from "react";
import { createProduct, getProducts } from "./api.js";
import ProductForm from "./components/ProductForm.jsx";
import ProductList from "./components/ProductList.jsx";

export default function App() {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    loadProducts();
  }, []);

  async function loadProducts() {
    try {
      setProducts(await getProducts());
      setError(null);
    } catch (err) {
      setError(err.message);
    }
  }

  async function handleCreate(name) {
    await createProduct(name);
    await loadProducts();
  }

  return (
    <div>
      <h1>Products</h1>
      {error && <p>Error: {error}</p>}
      <ProductForm onCreate={handleCreate} />
      <ProductList products={products} />
    </div>
  );
}
