<style>
    .Content {
        display: flex;
        justify-content: space-between;
        align-items: flex-start;
        width: 100%;
        min-height: 100vh;

    }

    .Content span {
        font-family: 'Fjalla One', sans-serif;
        padding-left: 1rem;
        margin-top: 1rem;
        margin-bottom: 3rem;
        font-size: 2.4rem;
        color: #F3FBF1;
    }

    .ContentLinks {
        padding: 2rem 1rem;
        flex: 0 0 18%;
        height: 100vh;
        display: flex;
        flex-direction: column;
        background-color: #363062;
        color: #FAAB78;
        position: fixed;
        left: 0;
        top: 0;
        z-index: 300;


    }

  .ContentLinkContent {
      margin-left: 18%;
        padding: 2rem;
        min-height: 100vh;
        flex: 1;
    }

    .ContentLinks a {
        font-size: 1.2rem;
        padding-left: 2.4rem;
        padding-top: 1rem;
        text-decoration: none;
        color: #F3FBF1;
    }

    .ContentLinks a.active {
        text-decoration: underline #7F669D;
    }

    .TourList {
        list-style-type: none;
        margin-top: 0.9rem;
        padding: .1rem;
    }

    .TourList li {
        background-color: #f9f9f9;
        margin: 0.5em 0;
        padding: 0.5em;
        border-bottom: 1px solid #ddd;
        border-radius: 5px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 4rem;
    }

    th, td {
        border: 1px solid #D1E4D1;
        text-align: left;
        padding: 1rem;
    }
    td i {
    padding-right: 0.5rem;
    color: #363062;
    }

    th {
        background-color: #EBE3D5;
    }

    .AddToursPage {
      
      box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
       margin-top: 3rem;
       padding: 1rem;
    }

    .AddToursPage form {
        width: 100%;
    }

    .AddToursPage input ,
    .AddToursPage select{
        box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 5px 0px, rgba(0, 0, 0, 0.1) 0px 0px 1px 0px;
        color: #1F1717;
        padding: 0.5rem 1rem;
        margin-bottom: .7rem;
        width: 100%;
        border: 1px solid #64868E;
        background-color: white;
        box-sizing: border-box;
        display: block;
        outline:none;
    }

    .AddToursPage input:focus {
        outline: none;
        background-color: #ccc;
        box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
    }

    .SubmitButton {
        padding: 0.8rem 1rem;
        font-weight: 500;
        margin-top: 0.9rem;
        width: 50%;
        font-size: 1rem;
        letter-spacing: 1px;
        border-radius: 0.5rem;
        outline: none;
        border: 1px solid #b3967e;
        background-color: #2a2f4f;
        color: aliceblue;
        transition: all 2s;
    }
      .StatCard {
       box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
        display: flex;
        justify-content: space-between;
        margin-top: 2.5rem;
        padding: 1rem;
      }

      .TotalStat,
       .MembersStat,
       .ActiveStat{
        width: 20%;
        padding: 1rem;
      }

      .StatCard h1 {
      color: #363062;
      font-size: 1.4rem;
      padding-top: 0.6rem;
      }

     .TableData {
      box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
       margin-top: 3rem;
       padding: 1rem;
      }
      .TableActions {
      width: 100%;
       display: flex;
       justify-content: space-between;
         align-items: center;
       padding: 1rem 0rem;
      }
      .TableActions .searchForm {
           font-size: 1rem;
           font-family: inherit;

      }
      .TableActions .searchInput {
        padding: 0.5rem 1rem;
        outline: none;
        border-radius: 5px;
        border: 1px solid #435B66;


      }
      .TableActions .searchButton {
         border-radius: 5px;
         padding: 0.5rem 1rem;
         border: 1px solid #435B66;
      }

      .TableActions .linkBtn {
      color: black;
      width: 20%;
      text-decoration: underline solid #363062;
      font-weight: 700;
      padding: 1rem;
      }

          @media screen and (min-width: 1800px) {
           .ContentLinks {
                 box-sizing: border-box;
                 width: 18%;
                  padding: 4rem 3rem;
             }

           .ContentLinkContent {
               margin-left: 20%;
             }

               .Content span {
                     margin-top: 2rem;
                     font-size: 2.6rem;

                 }
          }
</style>