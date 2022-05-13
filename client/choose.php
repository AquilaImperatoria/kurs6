
<a href="/newchat.php" target="_blank">
     <input type="submit" value="Создать новый чат"/>
   </a>
<form name='form' method='post' action="chat.php" target="_blank">

    Подключиться к имеющемуся чату:<br> <input type="text" name="chatcode" id="chatcode" ><br/>

    <input type="submit" name="submit" value="Submit">

</form>
<a href="index.php"><input type="submit" value="Выйти из аккаунта"/></a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
    function clickMe(id) {
        document.getElementById('chatcode').value = id;
    }
</script>
<?php
session_start();
$url = 'kurs6-server.herokuapp.com/messages/getuser';
$content = array('user' => $_SESSION['name']);
function httpGet($url, $content)
{
    $curl = curl_init($url);
    $url = 'kurs6-server.herokuapp.com/messages/getuser?' . http_build_query($content);
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_HEADER, false);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    $result = curl_exec($curl);
    curl_close($curl);
    return $result;
}
$chats[] = null;
$res = json_decode(httpGet($url, $content));
$i = 0;
if (sizeof($res)!= 0)
echo "<p>Мои чаты:</p>";
while ($i < sizeof($res)) {
    if (!in_array($res[$i]->chatcode, $chats)) {
        array_push($chats, $res[$i]->chatcode);
        echo "<button id ='".$res[$i]->chatcode."'type='submit'  onclick='clickMe(this.id)'>".$res[$i]->chatcode."</button>";
    }
    $i = $i + 1;
}

?>

