# notes-ota
Tech exam for OTA


This is made for tech examination only

Specific Requirements

1. API Endpoints:

        · POST /notes: Create a new note.
        
        · GET /notes: Retrieve all notes.
        
        · GET /notes/:id: Retrieve a specific note by ID.
        
        · PUT /notes/:id: Update a specific note.
        
        · DELETE /notes/:id: Delete a specific note.

2. Data Storage: Use an in-memory array or a simple file-based solution to store notes.

3. Data Validation: Validate input data for creating and updating notes.

4. Error Handling: Basic error handling for common scenarios (e.g., note not found).

How to run:
1. Clone this repo
2. Open command line on the folder
3. run `mvn clean install`
4. go to `/target` folder
5. run `java -jar notes-ota-0.0.1-SNAPSHOT.jar`
6. Open POSTMAN
7. Import the `Notes OTA Collection.postman_collection.json` in this repo
8. Run the tests
