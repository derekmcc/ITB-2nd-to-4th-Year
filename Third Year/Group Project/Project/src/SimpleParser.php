<?php
/**
 * Created by PhpStorm.
 * User: Derek
 * Date: 20/03/2018
 * Time: 16:34
 */

namespace Itb;


class SimpleParser
{
    public function parseAndSum($numbers)
    {
        $isEmptyString = (strlen($numbers) === 0);

        if ($isEmptyString){
            return 0;
        }

        $containsCommas = strrchr($numbers, ',');

        if (!$containsCommas){
            return intval($numbers);
        } else	{
            throw new \Exception('I can only handle 0 or 1 numbers for now!');
        }
    }

}