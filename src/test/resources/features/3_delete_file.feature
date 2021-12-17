Feature: Delete File
  Background: I am authorized dropbox user

  Scenario Outline: User can delete file from his dropbox folder
    Given I want to delete file by existing filepath "<filepath>"
    When I send POST request to "https://api.dropboxapi.com/2/files/delete_v2"
    Then I will get response with status code "200 OK", which contains "FileMetadata"

    Examples:
      | filepath                        |
      | /data_analytics_imgs/first.png  |
      | /data_analytics_imgs/second.png |

  Scenario Outline: User will get error while deleting file if filepath is invalid
    Given I want to delete file by invalid filepath "<filepath>"
    When I send POST request to "https://api.dropboxapi.com/2/files/delete_v2"
    Then I will get response with status code "400 Bad Request or 409 Conflict", which contains "Error"

    Examples:
      | filepath                 |
      | /invalid_path//first.png |
      | ????format?              |