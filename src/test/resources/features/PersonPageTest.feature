
@smoke
Feature: Visit person Detail Screen in  the app.

  Background: A Person Page
     
    
  Scenario Outline: Person Page Elements Verification

  As a user I should be able to see and fill person Screen Elements

  in  the app. 
  
   Given I navigate to the person page    
  
    Then  check that "<element>"  "<present>"
    
    When I enter "<text>" to "<name>"
    
    Then "<text>" should be visible on "<name>"
    

    Examples:
      | element  | present| text|name|
      | txt_nome |   true   |John|txt_nome|
     
  
      
      
      
      



