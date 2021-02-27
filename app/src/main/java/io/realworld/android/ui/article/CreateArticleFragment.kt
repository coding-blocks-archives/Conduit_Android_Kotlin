package io.realworld.android.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.realworld.android.databinding.FragmentCreateArticleBinding

class CreateArticleFragment: Fragment() {


    private var _binding:FragmentCreateArticleBinding?= null
    private lateinit var articleViewModel:ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCreateArticleBinding.inflate(layoutInflater,container,false)
        articleViewModel= ViewModelProvider(this).get(ArticleViewModel::class.java)


        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            submitButton.setOnClickListener{
                articleViewModel.createArticle(
                        title=articleTitleTv.text.toString().takeIf { it.isNotBlank() },
                        description = articleDesciptionTv.text.toString().takeIf { it.isNotBlank() },
                        body = articleBodyTv.text.toString().takeIf{it.isNotBlank()},
                        tagList = articleTagTv.text.toString().split("\\s".toRegex())
                )
                Toast.makeText(requireContext(),"Article Published",Toast.LENGTH_SHORT).show()
            }
        }
    }

}