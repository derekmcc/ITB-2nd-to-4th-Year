<?PHP
$product = \Itb\Product::getOneById($id)
;?>
<h1><a href="index.php?action=shop">Back</a></h1>
<h1>Product Details</h1>

<dl>
    <dt><img src="<?= $product->getImage() ?>" alt="Guardians of the Galaxy" width="183" height="226"></dt>
    <dt><strong>ID:</strong></dt>
    <dd><?= $product->getId() ?></dd>
    <dt><strong>Name:</strong></dt>
    <dd><?= $product->getName() ?></dd>
    <dt><strong>Description:</strong></dt>
    <dd><?= $product->getDescription() ?></dd>
    <dt><strong>Price:</strong></dt>
    <dd>€<?= $product->getPrice() ?></dd>
    <dt><strong>Stock quantity:</strong></dt>
    <dd><?= $product->getQuantity() ?></dd>
</dl>
