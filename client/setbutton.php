<?php
session_start();
$id = $_GET['id'];
$_SESSION['chatcode'] = $id;
header( "Location: /chat.php" );
?>