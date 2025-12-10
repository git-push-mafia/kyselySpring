# Questionnaire app, REST API documentation


### Base URL 
```
https://kysely-spring-git-gitpushmafia.2.rahtiapp.fi/
```

## Kyselyt
**Translation**: *Questionnaires*

### Base URL 
```
https://kysely-spring-git-gitpushmafia.2.rahtiapp.fi/api/
```
### Endpoints 

**Get all questionnaires**

Retrieve all questionnaires from REST.

**Request**: 

- HTTP Method: ```GET``` 
- Endpoint: ```/kyselyt```
- Request parameters: None

**Response**:

Each kysely object includes following fields: 

- ```kyselyId```: An ID that individualises the questionnare. (long)
- ```nimi```: A name of the questionnaire. (string)
- ```kuvaus```: A description of the questionnaire's topic. (string)
- ```aloituspmv```: Date when the questionnaire opens for answers. (localdate)
- ```lopetuspmv```: Date when the questionnaire opens for answers. (localdate)
- ```kysymykset```: An array of questions that the questionnaire contains (list).

Example Response: 

```
    {
        "kyselyId": 1,
        "nimi": "kysely kyselystä",
        "kuvaus": "mitä kyselet",
        "aloituspvm": null,
        "lopetuspvm": null,
        "kysymykset": []
    },
```
**Get Questionnaire by Id**

Retrieves specific questionnaire from REST.

**Request**:

- HTTP Method: ```GET```
- Endpoint: /kyselyt/{kyselyId}
- Path parameters: {kyselyId} (long, required) is the unique identifier of the questionnaire.

Example Request: 

```
GET kyselyt/1
```


## Kysymykset
**Translation**: *Questions*

### Base URL 
```
https://kysely-spring-git-gitpushmafia.2.rahtiapp.fi/api/
```

### Endpoints 

**Get all questions**

Retrieve all questions of the questionnaire from REST.

**Request**: 

- HTTP Method: ```GET``` 
- Endpoint: ```/kyselyt/{kyselyId}/kysymykset/```
- Request parameters: {kyselyId} (long, required) is the unique identifier of the questionnaire


**Response**: 

Each list of questions includes following fields: 

Each kysely object includes following fields: 

- ```kysymysId```: An ID that identifies the question. (long)
- ```kysymys```: The question that's asked. (string)
- ```vastaustyyppi```: Determines how the question is answered to: in text or multiple choices. (string)
- ```vaihtoehdot```: An array of options that the question may contain for answering (list).

Example Response: 

```
  {
    "kyselyId": 3,
    "nimi": "Musiikkikysely",
    "kuvaus": "Musiikin ystäville tarkoitettu kysely",
    "aloituspvm": null,
    "lopetuspvm": null,
    "kysymykset": [
        {
            "kysymysId": 1,
            "kysymys": "Miten paljon kuuntelet musiikkia?",
            "vastaustyyppi": "monivalinta",
            "vaihtoehdot": []
        },
        {
            "kysymysId": 2,
            "kysymys": "Missä kuuntelet musiikkia eniten?",
            "vastaustyyppi": "monivalinta",
            "vaihtoehdot": []
        },
        {
            "kysymysId": 3,
            "kysymys": "Mikä on lempiyhtyeesi",
            "vastaustyyppi": "teksti",
            "vaihtoehdot": []
        },
        {
            "kysymysId": 4,
            "kysymys": "Mikä on lempigenresi?",
            "vastaustyyppi": "teksti",
            "vaihtoehdot": []
        }
    ]
}
```

**Get Question by Id**

Retrieves one question from a questionnaire.

**Request**:

- HTTP Method: GET
- Endpoint: /kyselyt/{kyselyId}/kysymykset/{kysymysId}
- Path parameters: {kyselyId} (long, required) and {kysymysId} (long, required) are the unique identifiers of the kysely and kysymys -objects.

Example Request: 

```
  GET /kyselyt/123/kysymykset/123
```


## Vastaukset
**Translation**: *Answers*


### Base URL 
```
https://kysely-spring-git-gitpushmafia.2.rahtiapp.fi/api/
```

### Endpoints

**Get All Answers**:

Retrieves all answers for all questionnaires.

**Request**: 

- HTTP Method: ```GET``` 
- Endpoint: ```/vastaukset```
- Request parameters: None

**Response**:

Each vastaus object includes following fields: 

- ```vastausId```: An ID that identifies the question. (long)
- ```vastaus```: The question that's asked. (string)

Example Response: 

```
[
  {
    "vastausId": 1,
    "vastaus": "Harry Potter",
    "kysymys": {
      "kysymysId": 7,
      "kysymys": "Kuka on paras Harry Potter hahmo?",
      "vastaustyyppi": "monivalinta",
      "vaihtoehdot": [
        {
          "vaihtoehtoId": 13,
          "vaihtoehto": "Harry Potter"
        },
        {
          "vaihtoehtoId": 14,
          "vaihtoehto": "Ron Weasley"
        },
        {
          "vaihtoehtoId": 15,
          "vaihtoehto": "Hermione Grainger"
        },
        {
          "vaihtoehtoId": 16,
          "vaihtoehto": "Severus Snape"
        }
      ]
    }
  },
  {
    "vastausId": 2,
    "vastaus": "Joo kiva sammakko",
    "kysymys": {
      "kysymysId": 8,
      "kysymys": "Miksi oikea vastaus on Neville Longbottom?",
      "vastaustyyppi": "teksti",
      "vaihtoehdot": []
    }
  }
]
```

**Get Answers by Questionnaire**

Retrieves all answer for the questionnaire.

**Request**: 

- HTTP Method: ```GET``` 
- Endpoint: ```/kyselyt/{kyselyId}/vastaukset```
- Request parameters: {kyselyId} (long, required) is an unique identifier of the questionnaire.


Example Request: 

```
  GET /kyselyt/123/vastaukset
```


