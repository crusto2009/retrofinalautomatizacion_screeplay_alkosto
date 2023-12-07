#language:es

Característica: Agregar productos de manera alatoria al carrito de compras
  Yo como usuario deseo buscar un producto y agregarlo al carrito de compras

  @addProducts
  Escenario: Agregar productos al carrito de compras de manera exitosa
    Dado que ingreso en la pagina de la tienda
    Cuando de clic en un producto y lo agrege al carrito
    Entonces  visualizo los productos que he seleccionado para comprar