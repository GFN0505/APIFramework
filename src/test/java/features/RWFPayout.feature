Feature: Validating RWF Payout

Scenario Outline: Verify if RWF payout is successful using PayoutAPI
		Given RWF Payout Payload with "<Narration>" "<Amount>" "<SenderIdNumber>"
		When user calls "PayoutAPI" with "Get" http request
		Then The api call is success with status code 200
		And "status" in response body is "success"
		And "message" in response body is "Transfer Queued Successfully"
		
Examples:
		|Narration    |Amount    |SenderIdNumber |
		|AutoTest1     |350       |2345645        |   
		|AutoTest2     |351       |2345649        |   
		
		
		
	