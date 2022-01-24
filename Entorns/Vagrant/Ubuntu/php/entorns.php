<?php
/* SI VEUS AQUEST MISSATGE VOL DIR QUE PHP NO ESTÀ BEN CONFIGURAT */
include('config.php');

$servername = MYSQL_HOST;
$username = MYSQL_USER;
$password = MYSQL_PASSWORD;
$dbname = MYSQL_DATABASE;

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create table
$sql = "CREATE TABLE IF NOT EXISTS users (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(128) NOT NULL,
lastname VARCHAR(128) NOT NULL,
email VARCHAR(254),
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)";

if ($conn->query($sql) === TRUE) {
    echo "Table created successfully";
} else {
    echo "Error creating table: " . $conn->error;
}

echo "<br><br><br>";

// Insert user
$sql = "INSERT INTO users (firstname, lastname, email)
VALUES ('Pere', 'Negre', 'admin@esliceu.com')";

if ($conn->query($sql) === TRUE) {
    echo "Record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

echo "<br><br><br>";

// Output rows
$sql = "SELECT id, firstname, lastname FROM user";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"] . " name: " . $row["firstname"] . " " . $row["lastname"] . "<br>";
    }
} else {
    echo "no results";
}

$conn->close();
