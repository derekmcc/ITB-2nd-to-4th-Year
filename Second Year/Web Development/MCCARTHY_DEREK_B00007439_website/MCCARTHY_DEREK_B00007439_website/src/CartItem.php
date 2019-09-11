<?php
/**
 * Cart class
 */

namespace Itb;

/**
 * Class CartItem
 * @package Itb
 */
class CartItem
{
    /**
     * product variable
     * @var mixed|null
     */
    private $product;

    /**
     * quantity variable
     * @var int
     */
    private $quantity = 1;

    /**
     * CartItem constructor.
     * @param $productId
     */
    public function __construct($productId)
    {
        $this->product = Product::getOneById($productId);
    }

    /**
     * get quantity
     * @return int
     */
    public function getQuantity()
    {
        return $this->quantity;
    }

    /**
     * set quantity
     * @param int $quantity
     */
    public function setQuantity($quantity)
    {
        $this->quantity = $quantity;
    }

    /**
     * get product
     * @return mixed
     */
    public function getProduct()
    {
        return $this->product;
    }

}