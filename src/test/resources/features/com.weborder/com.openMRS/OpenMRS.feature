Feature: OpenMRS tests

  @openMRS
  Scenario: Register a patient
    Given a user logs in to OpenMrs with following credentials
      | username | admin    |
      | password | Admin123 |

    When the user register a new pacient with following information:
      | GivenName    | George       |
      | FamilyName   | Bularca      |
      | Gender       | Male         |
      | Day          | 17           |
      | Month        | June         |
      | Year         | 2002         |
      | Address      | 2200 E Devon |
      | PhoneNumber  | 3127738579   |
      | RelationType | Doctor       |
      | RelativeName | Potel        |
    Then the user validates the patient name and familyName
      | GivenName  | George  |
      | FamilyName | Bularca |


