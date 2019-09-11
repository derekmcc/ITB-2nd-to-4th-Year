<?php

require_once __DIR__ . '/_head.php';
require_once __DIR__ . '/_nav.php';

$products = \Itb\Product::getAll();

?>

    <form action="index.php?action=payConfirm" method="post">

        <h3><strong>Enter Shipping Details</strong></h3>
        <br>
        <p>
            First Name:
            <br>
            <input type="text" name="firstname">
            <br>
            <br>
            Surname:
            <br>
            <input type="text" name="surname">
            <br>
            <br>
            Address 1:
            <br>
            <input type="text" name="address1">
            <br>
            <br>
            Address 2:
            <br>
            <input type="text" name="address2">
            <br>
            <br>
            Address 3:
            <br>
            <input type="text" name="address3">
            <br>
        </p>
        <p>
            <br>
            <input type="submit" value="Confirm & Pay">
        </p>
    </form>
<?=require_once '_cart.php';?>