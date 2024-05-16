package com.rishabh.portfolio.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
import com.rishabh.portfolio.Domain.Blogs;
import com.google.cloud.firestore.WriteResult;

@Service
public class BlogService {

	public String save(Blogs blog) throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		Blogs newBlog = new Blogs();
		newBlog.setId(blog.getId());
		newBlog.setTitle(blog.getTitle());
		newBlog.setContent(blog.getContent());
		newBlog.setDate(new Date().toString());
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("blogs").document(blog.getId())
				.set(newBlog);
		return collectionsApiFuture.get().getUpdateTime().toString();

	}

	public Blogs getBlogById(String id) throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("blogs").document(id);

		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		Blogs blog = null;

		if (document.exists()) {
			blog = document.toObject(Blogs.class);
			return blog;
		} else {
			return null;
		}
	}

	public ArrayList<Blogs> getAllBlogs() throws InterruptedException, ExecutionException {

		ArrayList<Blogs> list = new ArrayList<>();
		Firestore dbFirestore = FirestoreClient.getFirestore();

		ApiFuture<QuerySnapshot> future = dbFirestore.collection("blogs").get();

		List<QueryDocumentSnapshot> documents = future.get().getDocuments();

		for (QueryDocumentSnapshot document : documents) {
			list.add(document.toObject(Blogs.class));
//    	  System.out.println(document.getId() + " => " + document.toObject(Blogs.class));
		}
		return list;
	}

	public String deleteById(String id) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("blogs").document(id).delete();
		return "Document with Blog ID " + id + " has been deleted";
	}

	public String updateById(Blogs blog) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		Blogs newBlog = new Blogs();
		newBlog.setId(blog.getId());
		newBlog.setTitle(blog.getTitle());
		newBlog.setContent(blog.getContent());
		newBlog.setDate(new Date().toString());
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("blogs").document(blog.getId()).set(newBlog);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

}
