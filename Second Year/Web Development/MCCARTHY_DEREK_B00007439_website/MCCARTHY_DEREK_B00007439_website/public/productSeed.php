<?php

require_once __DIR__ . '/../vendor/autoload.php';

use Itb\Product;

define('DB_HOST','localhost');
define('DB_USER', 'root');
define('DB_PASS', 'root');
define('DB_NAME', 'guardians');

$product1 = new Product();
$product1->setName('Gamora');
$product1->setDescription('Gamora Cardboard Cutout');
$product1->setImage('images/stock/img1.png');
$product1->setQuantity(25);
$product1->setPrice(40.00);

$product2 = new Product();
$product2->setName('Groot');
$product2->setDescription('Groot Mr. Potato Head');
$product2->setImage('images/stock/img2.png');
$product2->setQuantity(20);
$product2->setPrice(14.99);

$product3 = new Product();
$product3->setName('Blanket');
$product3->setDescription('Poster Fleece Throw Blanket');
$product3->setImage('images/stock/img3.png');
$product3->setQuantity(15);
$product3->setPrice(26.99);

$product4 = new Product();
$product4->setName('Groot');
$product4->setDescription('I am Groot Button');
$product4->setImage('images/stock/img4.png');
$product4->setQuantity(46);
$product4->setPrice(2.00);

$product5 = new Product();
$product5->setName('Rocket Raccoon');
$product5->setDescription('Rocket Raccoon Soft Keychain');
$product5->setImage('images/stock/img5.png');
$product5->setQuantity(58);
$product5->setPrice(3.99);

$product6 = new Product();
$product6->setName('Groot');
$product6->setDescription('Dancing Groot Cookie Jar');
$product6->setImage('images/stock/img6.png');
$product6->setQuantity(52);
$product6->setPrice(34.00);

$product7 = new Product();
$product7->setName('Drax');
$product7->setDescription('Drax Cardboard Cutout');
$product7->setImage('images/stock/img7.png');
$product7->setQuantity(33);
$product7->setPrice(40.00);

$product8 = new Product();
$product8->setName('Mug');
$product8->setDescription('GOTG Ceramic Mug');
$product8->setImage('images/stock/img8.png');
$product8->setQuantity(55);
$product8->setPrice(9.99);

$product9 = new Product();
$product9->setName('Star Lord');
$product9->setDescription('Star Lord Button');
$product9->setImage('images/stock/img9.png');
$product9->setQuantity(90);
$product9->setPrice(1.99);

$product10 = new Product();
$product10->setName('T-Shirt');
$product10->setDescription('Rocket Symbol T-Shirt');
$product10->setImage('images/stock/img10.png');
$product10->setQuantity(40);
$product10->setPrice(21.99);

$product11 = new Product();
$product11->setName('Star Lord');
$product11->setDescription('Star Lord Bobble Head');
$product11->setImage('images/stock/img11.png');
$product11->setQuantity(39);
$product11->setPrice(16.99);

$product12 = new Product();
$product12->setName('Wristband');
$product12->setDescription('GOTG Wristband Set');
$product12->setImage('images/stock/img12.png');
$product12->setQuantity(50);
$product12->setPrice(8.99);

Product::insert($product1);
Product::insert($product2);
Product::insert($product3);
Product::insert($product4);
Product::insert($product5);
Product::insert($product6);
Product::insert($product7);
Product::insert($product8);
Product::insert($product9);
Product::insert($product10);
Product::insert($product11);
Product::insert($product12);

$products = Product::getAll();
var_dump($products);