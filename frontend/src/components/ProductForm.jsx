import { useState } from "react";

export default function ProductForm({ onCreate }) {
  const [name, setName] = useState("");
  const [submitting, setSubmitting] = useState(false);

  async function handleSubmit(event) {
    event.preventDefault();
    if (!name.trim()) {
      return;
    }
    setSubmitting(true);
    try {
      await onCreate(name.trim());
      setName("");
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={name}
        onChange={(event) => setName(event.target.value)}
        placeholder="Product name"
      />
      <button type="submit" disabled={submitting}>
        Add product
      </button>
    </form>
  );
}
