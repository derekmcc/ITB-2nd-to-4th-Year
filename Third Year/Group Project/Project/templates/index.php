<?php require_once __DIR__ . '/../templates/_head.php'; ?>
<?php require_once __DIR__ . '/../templates/_nav.php'; ?>
<?php $albums = \Itb\Album::getAll()?>
<?php $songs = \Itb\Single::getAll()?>
<?php $counter = 0;$count=0;
$songArray = array();
$albumArray = array();?>
<br>
<div class="container">
    <div class="jumbotron jumbotron-sm">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-lg-12">
                    <h1 class="display-4">Shop By Albums</h1>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div id="recipeCarousel1" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner" role="listbox">
                <?php
                foreach($albums as $album) {
                    $count++;
                }
                for ($i=1;$i<11;$i++){
                    $albumArray[] =  \Itb\Album::getAlbumByAlbumID(rand($i,$count));
                }?>
                <?php $albu = \Itb\Album::getAlbumByAlbumID(rand(1,$count));?>

                <div class="carousel-item active">
                    <img class="d-block col-4 img-fluid" src="<?= $albu->getAlbumImage()?>">
                    <div class="carousel-caption d-none d-md-block">
                        <h5><?= $albu->getAlbumName()?></h5>
                        <p><i class="fas fa-cart-plus"></i></p>
                    </div>
                </div>
                <?php foreach($albumArray as $album) { ?>
                <div class="carousel-item">
                    <a href="index.php?action=showAlbum&albumName=<?= $album->getAlbumName() ?>"><img class="d-block col-4 img-fluid" src="<?= $album->getAlbumImage()?>"></a>
                    <div class="carousel-caption d-none d-md-block">
                        <h5><?= $album->getAlbumName()?></h5>
                        <p><i class="fas fa-cart-plus"></i></p>
                    </div>
                </div>
                <?php }?>
            </div>
            <a class="carousel-control-prev" href="#recipeCarousel1" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#recipeCarousel1" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>
<br>
<br>
<div class="container">
    <div class="jumbotron jumbotron-sm">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-lg-12">
                    <h1 class="display-4">Shop By Song</h1>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div id="recipeCarousel2" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner" role="listbox">
                <?php
                foreach($songs as $song) {
                    $counter++;
                }
                for ($i=0;$i<10;$i++){
                    $songArray[] =  \Itb\Single::getSingleById(rand($i,$counter));
                }?>
                <?php $son = \Itb\Single::getSingleById(rand($i,$counter));?>

                <div class="carousel-item active">
                    <img class="d-block col-4 img-fluid" src="<?= $son->getSongImage()?>">
                </div>
                <?php foreach($songArray as $song) { ?>
                    <div class="carousel-item">
                        <a href="index.php?action=showAlbum&albumName=<?= $album->getAlbumName() ?>"><img class="d-block col-4 img-fluid" src="<?= $song->getSongImage()?>"></a>
                    </div>
                <?php }?>
            </div>
            <a class="carousel-control-prev" href="#recipeCarousel2" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#recipeCarousel2" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>
<fieldset class="rating">
    <input type="radio"
           value="5"
            />
    <label title="Rocks!" (click)='onClick(5)'>5 stars</label>

    <input type="radio"
           value="4"
           />
    <label title="Pretty good" (click)='onClick(4)'>4 stars</label>

    <input type="radio"
           value="3"
            />
    <label title="Meh" (click)='onClick(3)'>3 stars</label>

    <input type="radio"
           value="2"
            />
    <label title="Kinda bad" (click)='onClick(2)'>2 stars</label>

    <input type="radio"
           value="1"
            />
    <label title="Sucks big time" (click)='onClick(1)'>1 star</label>
</fieldset>
<style>
    /*.carousel-control-prev-icon {margin-left: 50px; color: black;}

    /*.carousel-control-next-icon {margin-right: 80px; color: black;}

    /* Set black background color, white text and some padding */
    footer {
        background-color: #555;
        color: white;
        padding: 15px;
    }
</style>
<style>
    @import url('https://fonts.googleapis.com/css?family=Roboto:300');
</style>
<script>
    $('#recipeCarousel1').carousel({
        interval: 10000
    })
    $('#recipeCarousel2').carousel({
        interval: 10000
    })
    $('.carousel .carousel-item').each(function(){
        var next = $(this).next();
        if (!next.length) {
            next = $(this).siblings(':first');
        }
        next.children(':first-child').clone().appendTo($(this));

        if (next.next().length>0) {
            next.next().children(':first-child').clone().appendTo($(this));
        }
        else {
            $(this).siblings(':first').children(':first-child').clone().appendTo($(this));
        }
    });
    </script>
<style>
    .img-fluid {
        max-width: 100%;
        height: auto;
    }
    .carousel {
        margin: auto;
    }
    .carousel-inner .carousel-item-right.active,
    .carousel-inner .carousel-item-next {
        transform: translateX(33.33%);
    }

    .carousel-inner .carousel-item-left.active,
    .carousel-inner .carousel-item-prev {
        transform: translateX(-33.33%)
    }

    .carousel-inner .carousel-item-right,
    .carousel-inner .carousel-item-left{
        transform: translateX(0);
    }
</style>
<?php require_once __DIR__ . '/../templates/_footer.php'; ?>
