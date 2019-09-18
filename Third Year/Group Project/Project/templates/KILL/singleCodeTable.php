<?php
require_once __DIR__ . '/../templates/_head.php';
require_once __DIR__ . '/../templates/_nav.php';

$singles = \Itb\Single::getAllSinglesInOrder();
$flag = false;
if($select1 != 'Filter By Category'){
    $flag = true;
}
?>

    <style>
        .well form {
            text-align: right;
        }
        .well {
            margin-top: 1em;
        }
    </style>
    <div class="container">
    <div class="well well-sm">
        <form action="index.php?action=setSongCat" method="post">
            <?php if($select1 != 'Filter By Category'){?>
            <p>Results For <?= $select1 ?>
                <?php }?>
                <select id="category" name="select"">
                <option value="Filter By Category"><?php if($select1 != 'Filter By Category'){?>
                        All
                    <?php }
                    else{ ?>

                        <?=$select1 ?><?php
                    }?></option>
                <option value="Pop">Pop</option>
                <option value="Jazz">Jazz</option>
                <option value="Rap">Rap</option>
                <option value="Heavy Metal">Heavy Metal</option>
                </select>
                <input type="submit" name="submit" value="Filter"/></p>
        </form>
    </div>
    <table class="table table-hover table-responsive">
        <thead>
        <tr>
            <th width="20%">Song</th>
            <th width="15%" class="hideCol">Album</th>
            <th width="15%" class="hideCol">Artist</th>
            <th width="40%" class="hideCol">Writer(s)</th>
            <th width="5%">Price</th>
            <th width="5%">Purchase</th>
        </tr>
        </thead>
        <tbody>
        <?php if ($flag == true){
            foreach($singles as $single) {
                if ($single->getSongCat() == $select1) {?>
                    <?php $artist = \Itb\Artist::getArtistById($single->getArtistID()) ?>
                    <?php $album = \Itb\Album::getAlbumNameByArtistID($single->getArtistID()) ?>
                    <tr>
                        <th><a href="index.php?action=showSong&songID=<?= $single->getSongID()?>"><?= $single->getSongName()?></a></th>
                        <th class="hideCol"><a href="index.php?action=showAlbum&albumName=<?= $album->getAlbumName() ?>"><?= $album->getAlbumName() ?></a></th>
                        <th class="hideCol"><a href="index.php?action=show&artistName=<?= $artist->getArtistName() ?>"><?= $artist->getArtistName() ?></a></th>
                        <th class="hideCol"><?= $single->getSongWriter() ?></th>
                        <th>€<?= $single->getSongPrice() ?></th>
                        <?php if($isLoggedIn){
                            ?>
                            <td><a href="index.php?action=addSongToCart&id=<?= $single->getSongID() ?>&type=Single" data-toggle="tooltip" data-placement="right" title="Add to Cart"><i class="fas fa-cart-plus fa-2x"></i></a></td>
                            <?php
                        }else{?>
                            <td><a href="#" data-toggle="modal" data-target="#id01"><span data-toggle="tooltip" data-placement="right" title="Add to Cart"><i class="fas fa-cart-plus fa-2x"></i></span></a></td>

                            <?php
                        }
                        ?>
                    </tr>
                <?php } ?>
            <?php } ?>
        <?php } else {
            foreach($singles as $single) {?>
                <?php $artist = \Itb\Artist::getArtistById($single->getArtistID()) ?>
                <?php $album = \Itb\Album::getAlbumNameByArtistID($single->getArtistID()) ?>
                <tr>
                    <th><a href="index.php?action=showSong&songID=<?= $single->getSongID() ?>"><?= $single->getSongName() ?></a></th>
                    <th class="hideCol"><a href="index.php?action=showAlbum&albumName=<?= $album->getAlbumName() ?>"><?= $album->getAlbumName() ?></a></th>
                    <th class="hideCol"><a href="index.php?action=show&artistName=<?= $artist->getArtistName() ?>"><?= $artist->getArtistName() ?></a></th>
                    <th class="hideCol"><?= $single->getSongWriter() ?></th>
                    <th>€<?= $single->getSongPrice() ?></th>
                    <?php if($isLoggedIn){
                        ?>
                        <td><a href="index.php?action=addSongToCart&id=<?= $single->getSongID() ?>&type=Single" data-toggle="tooltip" data-placement="right" title="Add to Cart"><i class="fas fa-cart-plus fa-2x"></i></a></td>
                        <?php
                    }else{?>
                        <td><a href="#" data-toggle="modal" data-target="#id01"><span data-toggle="tooltip" data-placement="right" title="Add to Cart"><i class="fas fa-cart-plus fa-2x"></i></span></a></td>
                        <?php
                    }
                    ?>
                </tr>
            <?php } ?>
        <?php } ?>
        </tbody>
    </table>
    <div class="modal fade" id="id01" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">User Not Logged In</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h2>You need to be logged in in order to purchase music.</h2>
                    <br>
                    <small><b>Not A Member</b></small>
                    <small>You can simply sign up for free account by clicking on the sign-up button in the top right corner of the page.</small>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
<?php require_once __DIR__ . '/_footer.php'; ?>