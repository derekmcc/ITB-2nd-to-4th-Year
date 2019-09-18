<?PHP
$file_url = 'music/myBand.m4a';
header('Content-Type: application/octet-stream');
header("Content-Transfer-Encoding: Binary");
header("Content-disposition: attachment; filename=\"" . basename($file_url) . "\"");
readfile($file_url);
header("Location : https://localhost/index.php")
?>