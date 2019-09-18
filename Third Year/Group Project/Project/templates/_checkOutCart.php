
    <?php

    $total = 0;
    $songTotal = 0;
   // if ($songCart == null) {
        foreach ($albumCart as $cartItem):
            $album = $cartItem->getAlbum();
            $subTotal = $album->getAlbumPrice() * $cartItem->getQuantity();
            $total += $subTotal;

        endforeach;
   // }
    //if ($albumCart == null) {
        foreach ($songCart as $cartIte):
            $song = $cartIte->getSong();
            $songSubTotal = $song->getSongPrice() * $cartIte->getQuantity();
            $songTotal += $songSubTotal;

        endforeach;
    //}
    $total += $songTotal;
    //-----------------------------
    ?>

    &euro; <?= $total ?>

