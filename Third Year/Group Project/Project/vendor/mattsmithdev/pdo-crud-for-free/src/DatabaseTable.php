<?php
namespace Mattsmithdev\PdoCrud;

class DatabaseTable
{
    /**
     * return name of MySQL table based on the class name
     * e.g. if class is: Itb\Dvd
     * then return
     *      dvds
     *
     * i.e. lower case with 's' on the end
     *
     * @return string
     */
    public static function getTableName()
    {
        $r = new \ReflectionClass(static::class);
        $classNameUpperCamelCase = $r->getShortName();
        $classNameLower = strtolower($classNameUpperCamelCase);


        return $classNameLower . 's';
    }

    /**
     * @return array
     */
    public static function getAll()
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $sql = 'SELECT * FROM ' . static::getTableName();

        $statement = $connection->prepare($sql);
        $statement->setFetchMode(\PDO::FETCH_CLASS, '\\' .  static::class);
        $statement->execute();

        $objects = $statement->fetchAll();
        return $objects;
    }

    /**
     * @param $id
     * @return mixed|null
     */
    public static function getOneById($id)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $sql = 'SELECT * from ' .  static::getTableName()  . ' WHERE id=:id';
        $statement = $connection->prepare($sql);
        $statement->bindParam(':id', $id, \PDO::PARAM_INT);
        $statement->setFetchMode(\PDO::FETCH_CLASS, '\\' .  static::class);
        $statement->execute();

        if ($object = $statement->fetch()) {
            return $object;
        } else {
            return null;
        }
    }


    /**
     * delete record for given ID - return true/false depending on delete success
     * @param $id
     *
     * @return bool
     */

    public static function delete($id)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $sql = 'DELETE from ' . static::getTableName()  . ' WHERE id=:id';
        $statement = $connection->prepare($sql);
        $statement->bindParam(':id', $id, \PDO::PARAM_INT);
        $queryWasSuccessful = $statement->execute();
        return $queryWasSuccessful;
    }


    /**
     * @param $columnName
     * @param $searchText
     * @return array
     */
    public static function searchByColumn($columnName, $searchText)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        // wrap wildcard '%' around the serach text for the SQL query
        $searchText = '%' . $searchText . '%';

        $sql = 'SELECT * FROM ' . static::getTableName()  . ' WHERE ' . $columnName . ' LIKE :searchText';
        $statement = $connection->prepare($sql);
        $statement->bindParam(':searchText', $searchText, \PDO::PARAM_STR);
        $statement->setFetchMode(\PDO::FETCH_CLASS, '\\' .  static::class);
        $statement->execute();

        $objects = $statement->fetchAll();

        return $objects;
    }


    /**
     * insert new record into the DB table
     * returns new record ID if insertation was successful, otherwise -1
     * @param DatabaseTable $object
     * @return integer
     */
    public static function insert(DatabaseTable $object)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $objectAsArrayForSqlInsert = DatatbaseUtility::objectToArrayLessId($object);
        $fields = array_keys($objectAsArrayForSqlInsert);
        $insertFieldList = DatatbaseUtility::fieldListToInsertString($fields);
        $valuesFieldList = DatatbaseUtility::fieldListToValuesString($fields);

        $sql = 'INSERT into '. static::getTableName()  . ' ' . $insertFieldList . $valuesFieldList;
        $statement = $connection->prepare($sql);
        $statement->execute($objectAsArrayForSqlInsert);

        $queryWasSuccessful = ($statement->rowCount() > 0);
        if ($queryWasSuccessful) {
            return $connection->lastInsertId();
        } else {
            return -1;
        }
    }


    /**
     * insert new record into the DB table
     * returns new record ID if insertion was successful, otherwise -1
     * @param DatabaseTable $object
     * @return integer
     */
    public static function update(DatabaseTable $object)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $objectAsArrayForSqlInsert = DatatbaseUtility::objectToArrayLessId($object);
        $fields = array_keys($objectAsArrayForSqlInsert);
        $updateFieldList = DatatbaseUtility::fieldListToUpdateString($fields);

        $sql = 'UPDATE '. static::getTableName() . ' SET ' . $updateFieldList  . ' WHERE id=:id';
        $statement = $connection->prepare($sql);

        // add 'id' to parameters array
        $objectAsArrayForSqlInsert['id'] = $object->getId();

        $queryWasSuccessful = $statement->execute($objectAsArrayForSqlInsert);

        return $queryWasSuccessful;
    }
}
