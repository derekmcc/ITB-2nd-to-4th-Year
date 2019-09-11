<?php
$products = \Itb\Product::getAll();
$pageTitle = 'Edit Products';
$adminCrudLinkStyle = 'current_page';
/*$indexLinkStyle = '';
$loginLinkStyle = '';
$shopLinkStyle = '';
$accountLinkStyle = '';
$shopsLinkStyle = '';*/
require_once __DIR__ . '/../_head.php';
require_once __DIR__ . '/../_nav.php';
?>
<table>
    <tr>
        <th>Image</th>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Edit Product</th>
        <th>Delete Product</th>
    </tr>

    <?php
    foreach($products as $product) {
        ?>

        <tr>
            <td><img src="<?= $product->getImage() ?>" alt="Guardians of the Galaxy" width="30" height="30"></td>
            <td><?= $product->getId() ?></td>
            <td><?= $product->getName() ?></td>
            <td><?= $product->getDescription() ?></td>
            <td><?= $product->getQuantity() ?></td>
            <td>€<?= $product->getPrice() ?></td>
            <td><a href="index.php?action=showUpdateProduct&id=<?= $product->getId() ?>">(UPDATE)</a></td>
            <td><a href="index.php?action=delete&id=<?= $product->getId() ?>">(DELETE)</a></td>
        </tr>
        <?php
    }
    ?>

</table>

<br>
    <form id="newProduct"
        action="index.php"
        method="get"
    >
        <input type="hidden" name="action" value="showNewProduct">
        <input type="submit" value="Create New Product">

    </form>

<?php require_once __DIR__ . '/../_footer.php';