
# AndroidMVVM  

### My basic understanding  

`Model`: Database + State + Business logic
`ViewModel`: Get data from `Model` and prepare observable data to the `View`
`View`: Listen `ViewModel`  and update UI

### Note

- `ViewModel`  **don't** tied to `View`
- Many `View` **can** tied to 1 `ViewModel`
- `ViewModel` only use the `ApplicationContext` so some tasks like (`startActivity`, `openDialog`) need to do in `View` (Activity/Fragment)

