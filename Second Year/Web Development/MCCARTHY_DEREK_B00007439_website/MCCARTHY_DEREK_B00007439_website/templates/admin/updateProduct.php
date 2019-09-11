
<h1>Update product</h1>

<form
    action="index.php?action=updateProduct"
    method="POST"
>
    <!-- ****** send ID, but don't let user see this ***** -->
    <input type="hidden" name="id" value="<?= $product->getId() ?>">
    <p>
        <label>Restock quantity:</label>
        <input type="text" name="name" value="<?= $product->getName() ?>">
    </p>

    <p>
        <label>Description:</label>
        <input type="text" name="description" value="<?= $product->getDescription() ?>">
    </p>

    <p>
        <label>Price:</label>
        <input type="text" name="price" value="<?= $product->getPrice() ?>">
    </p>


    <p>
        <label>Stock quantity:</label>
        <input type="text" name="quantity" value="<?= $product->getQuantity() ?>">
    </p>

    <p>
        <label>Image:</label>
        <input type="text" name="image" value="<?= $product->getImage() ?>">
    </p>
    <input type="submit" value="Update Product">

</form>