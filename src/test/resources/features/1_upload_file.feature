Feature: Upload File
  Background: I am authorized dropbox user

  Scenario Outline: User can upload file to his dropbox folder
    Given I want upload "<filename>" to folder "<folder_dropbox>" with name "<filename_dropbox>"
    When I send POST request to "https://content.dropboxapi.com/2/files/upload"
    Then I will get response with status code "200 OK", which contains "FileMetadata"

    Examples:
      | filename                                 | folder_dropbox       | filename_dropbox |
      | /data_analytics_imgs/Example_img_no1.png | /data_analytics_imgs | first.png        |
      | /data_analytics_imgs/Example_img_no2.png | /data_analytics_imgs | second.png       |

  Scenario Outline: User will get error in response if his request in incorrect
    Given I want upload "<filename>" to folder "<folder_dropbox>" with name "<filename_dropbox>"
    And some of upload request parameters is invalid
    When I send POST request to "https://content.dropboxapi.com/2/files/upload"
    Then I will get response with status code "400 Bad Request or 409 Conflict", which contains "Error"

    Examples:
      | filename                                 | folder_dropbox        | filename_dropbox |
      | /data_analytics_imgs/Example_img_no1.png | /data_analytics_imgs  | //first.png      |
      | /data_analytics_imgs/Example_img_no2.png | dat//analytics_imgs\/ | second.png       |