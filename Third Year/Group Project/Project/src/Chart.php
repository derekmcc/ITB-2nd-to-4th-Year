<?php
/**
 * Created by PhpStorm.
 * User: Derek
 * Date: 21/12/2017
 * Time: 13:31
 */

namespace Itb;

use Mattsmithdev\PdoCrud\DatabaseTable;
use Mattsmithdev\PdoCrud\DatabaseManager;

class Chart extends DatabaseTable
{
    private $chartID;
    private $chartAlbum;
    private $chartArtist;
    private $chartWeeks;
    /**
     * @return mixed
     */
    public function getChartID()
    {
        return $this->chartID;
    }

    /**
     * @param mixed $chartID
     */
    public function setChartID($chartID)
    {
        $this->chartID = $chartID;
    }

    /**
     * @return mixed
     */
    public function getChartAlbum()
    {
        return $this->chartAlbum;
    }

    /**
     * @param mixed $chartAlbum
     */
    public function setChartAlbum($chartAlbum)
    {
        $this->chartAlbum = $chartAlbum;
    }

    /**
     * @return mixed
     */
    public function getChartArtist()
    {
        return $this->chartArtist;
    }

    /**
     * @param mixed $chartArtist
     */
    public function setChartArtist($chartArtist)
    {
        $this->chartArtist = $chartArtist;
    }

    /**
     * @return mixed
     */
    public function getChartWeeks()
    {
        return $this->chartWeeks;
    }

    /**
     * @param mixed $chartWeeks
     */
    public function setChartWeeks($chartWeeks)
    {
        $this->chartWeeks = $chartWeeks;
    }

    public function getChartImage($albumName)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $sql = "SELECT * FROM albums WHERE albumName=:albumName";
        $statement = $connection->prepare($sql);
        $statement->bindParam(':albumName', $albumName, \PDO::PARAM_STR);
        $statement->setFetchMode(\PDO::FETCH_CLASS, __CLASS__);
        $statement->execute();

        if ($object = $statement->fetch()) {
            return $object;
        } else {
            return null;
        }
    }
/*
    public static function getOneByArtist($artist)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $sql = "SELECT * FROM artists WHERE artistName='$artist'";
        $numRowsAffected = $connection->exec($sql);

        // can set Boolean variable in a single statement
        // 	$queryWasSuccessful = ($numRowsAffected > 0);

        if($numRowsAffected > 0){
            $queryWasSuccessful = true;
        } else {
            $queryWasSuccessful = false;
        }
        return $queryWasSuccessful;
    }*/
}