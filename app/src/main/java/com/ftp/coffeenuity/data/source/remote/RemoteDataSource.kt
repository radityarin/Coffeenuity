package com.ftp.coffeenuity.data.source.remote

import com.ftp.coffeenuity.data.source.remote.network.ApiResponse
import com.ftp.coffeenuity.data.source.remote.network.ApiServiceFuzzyAHP
import com.ftp.coffeenuity.data.source.remote.network.request.PetaniRequest
import com.ftp.coffeenuity.data.source.remote.network.response.IndeksBerkelanjutan
import com.ftp.coffeenuity.data.source.remote.network.response.PetaniResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.utils.Constants
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import timber.log.Timber

class RemoteDataSource(
    private val firebaseAuth: FirebaseAuth,
    private val apiServiceFuzzyAHP: ApiServiceFuzzyAHP
) {

    private val mPostsCollection =
        FirebaseFirestore.getInstance().collection(Constants.COLLECTION_POST)
    private val mUsersCollection =
        FirebaseFirestore.getInstance().collection(Constants.COLLECTION_USER)
    private val mStoryCollection =
        FirebaseFirestore.getInstance().collection(Constants.COLLECTION_STORY)

//    fun getAllPosts() = flow<ApiResponse<List<PostResponse>>> {
//        val snapshot = mPostsCollection.get().await()
//        val posts = snapshot.toObjects(PostResponse::class.java)
//        val newPost = mutableListOf<PostResponse>()
//        for (post in posts) {
//            var np = post
//            var liked = false
//            for (like in post.userLikes) {
//                if (like.idUser == UserPref.idUser) {
//                    liked = true
//                }
//            }
//            np.isLiked = liked
//            newPost.add(np)
//        }
//        emit(ApiResponse.Success(newPost))
//    }.catch {
//        emit(ApiResponse.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun getStories() = flow<ApiResponse<List<StoryResponse>>> {
//        val snapshot = mStoryCollection.get().await()
//        val story = snapshot.toObjects(StoryResponse::class.java)
//        emit(ApiResponse.Success(story))
//    }.catch {
//        emit(ApiResponse.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun getStoriesWithSpecificUserID(idUser: String) = flow<ApiResponse<List<StoryResponse>>> {
//        val snapshot =
//            mStoryCollection.whereEqualTo(Constants.COLLECTION_GENERAL_ATTRIBUTE_ID_USER, idUser)
//                .get().await()
//        val story = snapshot.toObjects(StoryResponse::class.java)
//        emit(ApiResponse.Success(story))
//    }.catch {
//        emit(ApiResponse.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun addPost(post: Post) = flow<Resource<Boolean>> {
//        emit(Resource.Loading())
//        post.idPost = mPostsCollection.document().id
//        mPostsCollection.document(post.idPost).set(post).await()
//        emit(Resource.Success(true))
//    }.catch {
//        emit(Resource.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun likePost(post: Post) = flow<Resource<DocumentReference>> {
//        emit(Resource.Loading())
//        val snapshot =
//            mPostsCollection.document(post.idPost)
//                .get().await()
//        val postUpdated = snapshot.toObject(Post::class.java)
//        val postRef = mPostsCollection.document(postUpdated?.idPost.toString())
//        val userLikes = Likes(postRef.id, UserPref.idUser, UserPref.username)
//        if (postUpdated?.userLikes?.contains(userLikes) == true) {
//            postRef.update(COLLECTION_ATTRIBUTE_POST_USER_LIKES, FieldValue.arrayRemove(userLikes))
//        } else {
//            postRef.update(COLLECTION_ATTRIBUTE_POST_USER_LIKES, FieldValue.arrayUnion(userLikes))
//        }
//        emit(Resource.Success(postRef))
//    }.catch {
//        emit(Resource.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun addStory(story: Story) = flow<Resource<Boolean>> {
//        emit(Resource.Loading())
//        story.idStory = mStoryCollection.document().id
//        mStoryCollection.document(story.idStory).set(story).await()
//        emit(Resource.Success(true))
//    }.catch {
//        emit(Resource.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)

    suspend fun getIndeksKeberlanjutanPetani(petaniRequest: PetaniRequest): Flow<PetaniResponse> {
        return flow {
            try {
                val response = apiServiceFuzzyAHP.getIndeksKeberlanjutanPetani(petaniRequest = petaniRequest)
                if (response.message.isNotBlank()) {
                    emit(response)
                }
            } catch (e: Exception) {
                Timber.e(e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    fun loginUser(email: String, password: String) = flow<Resource<AuthResult>> {
        emit(Resource.Loading())
        val loginAuth = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        emit(Resource.Success(loginAuth))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun registerUser(email: String, password: String) = flow<Resource<AuthResult>> {
        emit(Resource.Loading())
        val registerAuth = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        emit(Resource.Success(registerAuth))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun addUser(user: User) = flow<Resource<Boolean>> {
        emit(Resource.Loading())
        mUsersCollection.document(user.idUser).set(user).await()
        emit(Resource.Success(true))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

//    fun getUserWithIDUser(idUser: String) = flow<ApiResponse<UserResponse>> {
//        val snapshot =
//            mUsersCollection.document(idUser)
//                .get().await()
//        val user = snapshot.toObject(UserResponse::class.java)
//        if (user != null) {
//            emit(ApiResponse.Success(user))
//        }
//    }.catch {
//        emit(ApiResponse.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun getAllUsers() = flow<ApiResponse<List<UserResponse>>> {
//        val snapshot =
//            mUsersCollection.whereNotEqualTo(
//                Constants.COLLECTION_GENERAL_ATTRIBUTE_ID_USER,
//                UserPref.idUser
//            )
//                .get().await()
//        val posts = snapshot.toObjects(UserResponse::class.java)
//        emit(ApiResponse.Success(posts))
//    }.catch {
//        emit(ApiResponse.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun setPhotoProfile(imageUrl: String) = flow<Resource<DocumentReference>> {
//        emit(Resource.Loading())
//        val userRef =
//            mUsersCollection.document(UserPref.idUser)
//        userRef.update(
//            mapOf(
//                "photoProfileUrl" to imageUrl
//            )
//        )
//        emit(Resource.Success(userRef))
//    }.catch {
//        emit(Resource.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)
//
//    fun uploadImage(imageUrl: Uri, firestorePath: String) = flow<Resource<String>> {
//        emit(Resource.Loading())
//        var urlPostImage = ""
//        val filepath: StorageReference = imageStorage.child(firestorePath)
//            .child(UUID.randomUUID().toString() + ".jpg")
//        filepath.putFile(Objects.requireNonNull(imageUrl)!!)
//            .continueWithTask { task ->
//                if (!task.isSuccessful) {
//                    throw Objects.requireNonNull(task.exception)!!
//                }
//                filepath.downloadUrl
//            }.addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val downloadUri = task.result
//                    urlPostImage = downloadUri.toString()
//                }
//            }.await()
//        emit(Resource.Success(urlPostImage))
//    }.catch {
//        emit(Resource.Error(it.message.toString()))
//    }.flowOn(Dispatchers.IO)

}