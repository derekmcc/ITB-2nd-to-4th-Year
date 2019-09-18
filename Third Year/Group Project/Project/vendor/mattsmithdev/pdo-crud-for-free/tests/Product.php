<?php
declare(strict_types=1);

namespace Mattsmithdev\PdoCrudTest;

    use Mattsmithdev\PdoCrud\DatabaseManager;
    use Mattsmithdev\PdoCrud\DatabaseTable;


class Product extends DatabaseTable
{
    /**
     * unique ID
     * @var int
     */
    private $id;

    /**
     * description of product
     * @var string
     */
    private $description;

    /**
     * price of product
     * @var float
     */
    private $price;

    /**
     * quantity in stock
     * @var int
     */
    private $quantityInStock;

    /**
     * quantity below which it is time to restock
     * @var int
     */
    private $restockQuantity;

    /**
     * getter for quantity in stock
     * @return int
     */
    public function getQuantityInStock()
    {
        return $this->quantityInStock;
    }

    /**
     * setter for quantity in stock
     * @param $quantityInStock int
     */
    public function setQuantityInStock(int $quantityInStock)
    {
        $this->quantityInStock = $quantityInStock;
    }

    /**
     * getter for restock quantity
     * @return int
     */
    public function getRestockQuantity():int
    {
        return $this->restockQuantity;
    }

    /**
     * setter for restock quantity
     * @param int $restockQuantity
     */
    public function setRestockQuantity(int $restockQuantity)
    {
        $this->restockQuantity = $restockQuantity;
    }

    /**
     * getter for id
     * @return int
     */
    public function getId():int
    {
        return $this->id;
    }

    /**
     * setter for id
     * @param int $id
     */
    public function setId(int $id)
    {
        $this->id = $id;
    }

    /**
     * getter for description
     * @return string
     */
    public function getDescription():string
    {
        return $this->description;
    }

    /**
     * setter for description
     * @param string $description
     */
    public function setDescription(string $description)
    {
        $this->description = $description;
    }

    /**
     * getter for price
     * @return float
     */
    public function getPrice():float
    {
        return $this->price;
    }

    /**
     * setter for price
     * @param float $price
     */
    public function setPrice(float $price)
    {
        $this->price = $price;
    }

    /**
     * DB query to get all Product objects whose current in stock level is below the restock level
     * (example of custom PDO query for this subclass of DatabaseTable)
     * @return array
     */
    public static function getAllBelowReorderQuantity():array
    {
        $dbManager = new DatabaseManager();
        $connection = $dbManager->getDbh();

        $sql = 'SELECT * FROM products WHERE quantityInStock < restockQuantity';

        $statement = $connection->prepare($sql);
        $statement->setFetchMode(\PDO::FETCH_CLASS, __CLASS__);
        $statement->execute();

        $objects = $statement->fetchAll();
        return $objects;
    }

    /**
     * get all products, returned as an associative array
     * (example of custom PDO working with associative items rather than arrays of objects)
     * @return array
     */
    public static function getAllAssociative():array
    {
        $dbManager = new DatabaseManager();
        $connection = $dbManager->getDbh();

        $sql = 'SELECT * from products';

        $statement = $connection->prepare($sql);
        // set FETCH MODE to associative array
        $statement->setFetchMode(\PDO::FETCH_ASSOC);

        $statement->execute();

        $objects = $statement->fetchAll();
        return $objects;
    }

}