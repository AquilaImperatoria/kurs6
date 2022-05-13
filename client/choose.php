
<a href="/newchat.php">
     <input type="submit" value="Создать новый чат"/>
   </a>
<form name='form' method='post' action="chat.php" target="_blank">

    Подключиться к имеющемуся чату:<br> <input type="text" name="chatcode" id="chatcode" ><br/>

    <input type="submit" name="submit" value="Submit">

</form>

<p>Мои чаты:</p>
<?php
session_start();
$url = 'kurs6-server.herokuapp.com/messages/getuser';
$content = $_SESSION['name'];
function httpGet($url, $content)
{
    $curl = curl_init($url);
    $url = 'kurs6-server.herokuapp.com/messages/getchatcode?' . http_build_query($content);
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_HEADER, false);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    $result = curl_exec($curl);
    curl_close($curl);
    return $result;
}

?>
<a href="index.php"><input type="submit" value="Выйти из аккаунта"/></a>
