Feature: Get File Metadata
  Background: I am authorized dropbox user

  Scenario Outline: User can have ability to get metadata of existing file
    Given I want to get metadata of file by existing path "<filepath>"
    When I send POST request to "https://api.dropboxapi.com/2/sharing/get_file_metadata"
    Then I will get response with status code "200 OK", which contains "FileMetadata"

    Examples:
    | filepath                        |
    | /data_analytics_imgs/first.png  |
    | /data_analytics_imgs/second.png |

  Scenario Outline: User will get error while getting file metadata if filepath is invalid
    Given I want to get metadata of file by invalid path "<filepath>"
    When I send POST request to "https://api.dropboxapi.com/2/sharing/get_file_metadata"
    Then I will get response with status code "409 Conflict", which contains "Error"

    Examples:
      | filepath                    |
      | //first.png                 |
      | /data_analytics_img//second |