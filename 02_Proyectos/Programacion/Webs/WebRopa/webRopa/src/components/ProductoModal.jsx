function ProductoModal({ producto, onClose }) {
  return (
    <div className="box">
      <h1>{producto.nombre}</h1>
      <button onClick={onClose}>Cerrar</button>
    </div>
  );
}

export default ProductoModal;
