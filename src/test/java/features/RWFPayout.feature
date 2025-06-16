Feature: Validating RWF Payout

Scenario: Verify if RWF payout is successful using PayoutAPI
		Given RWF Payout Payload
		When user calls "Payout API" with Post http request and sets currency as "RWF"
		Then The api call is success with status code 200
		And "status" in response body is "success"
		And "message" in response body is "Transfer Queued Successfully"