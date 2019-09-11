<h1>Create a new product</h1>

<form
    action="index.php?action=createProduct"
    method="POST"
>
    <p>
        <label>Name:</label>
        <input type="text" name="name">
    </p>

    <p>
        <label>Description:</label>
        <input type="text" name="description">
    </p>

    <p>
        <label>Price:</label>
        <input type="text" name="price">
    </p>


    <p>
        <label>Quantity:</label>
        <input type="text" name="quantity">
    </p>

    <p>
        <label>Image:</label>
        <input type="text" name="image">
    </p>

    <input type="submit" value="Create New Product">

</form>