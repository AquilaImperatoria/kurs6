<?php
session_start();
$url = 'http://localhost:8080//newuser';
$name = $_POST['name'];
$password = $_POST['password'];
$data = array(
    'name' => $name,
    'password' => $password
);
$content = json_encode($data);
$status = httpPost($url, $content);
function httpPost($url, $content)
{
    $curl = curl_init($url);
    curl_setopt($curl, CURLOPT_HEADER, false);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($curl, CURLOPT_HTTPHEADER,
        array("Content-type: application/json"));
    curl_setopt($curl, CURLOPT_POST, true);
    curl_setopt($curl, CURLOPT_POSTFIELDS, $content);
    $response = curl_exec($curl);
    $status = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    curl_close($curl);
    return $status;
}

$message = "Ошибка при регистрации, попробуйте зарегистрироваться под другим именем";
if ($status != 201) {  $_SESSION['alerts'] = $message; header( "Location: https://kurs6-client.herokuapp.com/register.php" );}
    else header( "Location: https://kurs6-client.herokuapp.com/index.php" );