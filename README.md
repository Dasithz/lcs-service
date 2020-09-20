# lcs-service

# Overview
This is a Spring Boot application to calculate the longest common string of the given list of strings

# Usage of API
API Details
```
HTTP Method : POST
URL : http://localhost:8080/lcs
```
**Request Body :**

```
{
    "setOfStrings": [
        {
            "value": "comcast"
        },
        {
            "value": "comcastic"
        },
        {
            "value": "broadcaster"
        }
    ]
}
```

**Resonse Body :**
```
{
    "lcs": [
        {
            "value": "comcast"
        }
    ],
    "error": null
}
```
