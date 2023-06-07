<?php

    include('connect.php');
    
    $name = $_POST["name"];
    $email = $_POST["email"];
    $pass = $_POST["password"];
    
    if($name=="" && $email=="" && $pass=="")
    {
        echo '0';
    }
    else
    {
        $sql ="insert into info2 (name,email,password) values ('$name','$email','$pass')";
        mysqli_query($con,$sql);
    }
    

?>