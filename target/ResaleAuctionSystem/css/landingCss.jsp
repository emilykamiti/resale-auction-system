<style>
    body {
        margin: 0;
        padding: 0;
        background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3xeWLTcqcwn3bfhHMr-dJ3hhdzS7acyUG5A&usqp=CAU');
        background-size: 100% 100%;
        background-repeat: no-repeat;
        background-position: center;
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: left;
        align-items: center;
        height: 100vh;

    }

    .NavbarContent {
        justify-content: space-between;
        background-color: grey;
        color: #F1EAFF;

    }

    .NavbarContent span {
        font-family: 'Fjalla One', sans-serif;
        font-size: 2.6rem;
        width: 100vw;
    }

    .topnav {
        justify-content: space-between;
        position: fixed;
        background-color: grey;
        top: 0px;
        width: 100%;
        display: flex;
        padding: 2.6rem;
        float: left;
        margin-bottom: 10px;
    }

    .topnav .left a {
        margin-right: 20px;
        text-decoration: none;
        color: #F1EAFF;
        font-size: 1.1rem;
        font-weight: bolder;
    }

    .topnav .right a {
        margin-right: 80px;
        text-decoration: none;
        color:rgb(238, 110, 64);
        font-size: 1.1rem;
        font-weight: bolder;
    }

    .topnav .right a:hover {
        color: hsl(0, 3%, 6%);
    }

    .topnav .left a:hover {
        color: hsl(20, 22%, 51%);
    }

    .topnav .left a.active {
        text-decoration: underline rgb(218, 79, 29)
    }

    .topnav .right a.active {
        text-decoration: underline rgb(218, 79, 29)
    }

    .heading {
        font-size: 4em;
        font-weight: 100;
        font-size: 400%;
        font-family: Raleway, sans-serif;
        margin-bottom: 10px;
        margin-bottom: 10px;
        color: #f35d4b;
        margin-left: 20px;
        margin-block-start: 2.33em;
        margin-block-end: 2.33em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;

    }

    .paragraph{
        margin-top: 40px;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-size: 48px;
        line-height: 1.8;
        color: #DEDEDE;
        margin: 0 0 10px;
        visibility: visible;
    }
    .button {
        margin-top: 10%;
        display: inline-block;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
        margin-left: 25px;
        transition: background-color 0.3s ease;
    }
</style>