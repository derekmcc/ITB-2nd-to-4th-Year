<?PHP
require_once __DIR__ . '/_head.php';
require_once __DIR__ . '/_nav.php';
?>
<section>
<h1>
    Site Map
</h1>

<ul>
    <li><a href="index.php">Home</a>
    <li><a href="index.php?action=about">About us</a>
    <li><a href="index.php?action=shop">Shop</a>
    <li><a href="">Site Map</a>
    <?php
    if($isLoggedIn){?>
        <li><a href="index.php?action=profile">Profile</a>
        <li><a href="index.php?action=adminCrud">Edit Products</a>
    <?php
    }
    ?>
</ul>
</section>
<?php
require_once __DIR__ . '/_footer.php';
?>