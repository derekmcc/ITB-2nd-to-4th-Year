<?PHP
require_once __DIR__ . '/_head.php';
require_once __DIR__ . '/_nav.php';

$products = \Itb\Product::getAll();

?>

<table>
    <tr>
        <th>Details</th>
        <th>Image</th>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Add to Cart</th>
    </tr>

    <?php
    foreach($products as $product) {
        ?>

    <tr>
        <td>
            <a href="index.php?action=show&id=<?= $product->getId() ?>">
                More Details</a>
        </td>
        <td><img src="<?= $product->getImage() ?>" alt="Guardians of the Galaxy" width="30" height="30"></td>
        <td><?= $product->getId() ?></td>
        <td><?= $product->getName() ?></td>
        <td><?= $product->getDescription() ?></td>
        <td><?= $product->getQuantity() ?></td>
        <td>€<?= $product->getPrice() ?></td>
        <?php if($isLoggedIn){
            ?>
            <td><a href="index.php?action=addToCart&id=<?= $product->getId() ?>">Add to Cart</a></td>
        <?php
        }else{?>
            <td><a href="index.php?action=login">Add to Cart</a></td>
        <?php
        }
        ?>
    </tr>
        <?php
    }
    ?>
</table>

<?php
if($isLoggedIn){
    require_once '_cart.php';
    ?>
    <br>
    <br>
    <a href="index.php?action=checkout">CHECKOUT</a>
<?php
}
require_once __DIR__ . '/_footer.php';
?>