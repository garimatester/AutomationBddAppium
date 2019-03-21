Feature: Visit Home Screen in  the app.

  Background: A Home Page
  
          Given package is launched 
          
          
            
  Scenario Outline: Home Page Elements Verification

  As a user I should be able to see Home Screen Elements

  in  the app.  
  
    
     And I navigate to the home page    
    
    Then  check that "<element>" is "<present>"
    
    
     
     
  Examples:
      |element|present|
      |refresh|true|
   
      
      
      



