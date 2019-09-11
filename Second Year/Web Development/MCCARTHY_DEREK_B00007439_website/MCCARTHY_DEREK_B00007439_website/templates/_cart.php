<hr>
<h1><strong>Shopping cart</strong></h1>
<table>
    <tr>
        <th>Product</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>sub-total</th>
        <th>(remove)</th>
    </tr>
<?php
//-----------------------------
$total = 0;

foreach($shoppingCart as $cartItem):
    $product = $cartItem->getProduct();
    $subTotal = $product->getPrice() * $cartItem->getQuantity();
    $total += $subTotal;
//-----------------------------
?>
    <tr>
    <td><?= $product->getDescription() ?></td>
    <td>&euro; <?= $product->getPrice() ?></td>
    <td><?= $cartItem->getQuantity() ?></td>
    <td><?= $subTotal ?></td>
    <td><a href="index.php?action=removeFromCart&id=<?= $product->getId() ?>">(remove from cart)</a></td>

    </tr>

<?php
//-----------------------------
endforeach;
//-----------------------------
?>

    <tr>
        <td colspan="3">Total</td>
        <td>&euro; <?= $total ?></td>
    </tr>

</table>

<a href="index.php?action=emptyCart">EMPTY CART</a>

