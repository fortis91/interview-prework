export default function ProductList({ products }) {
  if (products.length === 0) {
    return <p>No products yet.</p>;
  }

  return (
    <ul>
      {products.map((product) => (
        <li key={product.id}>{product.name}</li>
      ))}
    </ul>
  );
}
