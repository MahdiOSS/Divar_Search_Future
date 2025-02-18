<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ویدیو و عکس کنار هم</title>
    <style>
        /* استایل کلی برای صفحه */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }

        /* استایل برای کانتینر */
        .container {
            display: flex;
            align-items: center;
            gap: 20px; /* فاصله بین ویدیو و عکس */
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* استایل برای ویدیو */
        .video-container {
            flex: 1;
        }

        video {
            width: 100%;
            max-width: 400px;
            border-radius: 10px;
        }

        /* استایل برای عکس */
        .image-container {
            flex: 1;
        }

        img {
            width: 100%;
            max-width: 400px;
            border-radius: 10px;
        }
    </style>
</head>
<body>

    <div class="container">
        <!-- ویدیو -->
        <div class="video-container">
            <video controls>
                <source src="https://www.w3schools.com/html/mov_bbb.mp4" type="video/mp4">
                مرورگر شما از ویدیو پشتیبانی نمی‌کند.
            </video>
        </div>

        <!-- عکس -->
        <div class="image-container">
            <img src="https://via.placeholder.com/400" alt="عکس نمونه">
        </div>
    </div>

</body>
</html>
