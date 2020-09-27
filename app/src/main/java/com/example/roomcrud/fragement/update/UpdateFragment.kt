package com.example.roomcrud.fragement.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomcrud.R
import com.example.roomcrud.model.User
import com.example.roomcrud.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [UpdateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateFragment : Fragment() {

   private val args by navArgs<UpdateFragmentArgs>()
   private lateinit var mUserViewModel : UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.editTextFirstName.setText(args.currentUser.firstName)
        view.editTextLastName.setText(args.currentUser.lastName)
        view.editTextAge.setText(args.currentUser.age.toString())

        view.buttonUpdate.setOnClickListener {
            updateItem()
        }

        view.buttonDelete.setOnClickListener {
            deleteUser()
        }


        return view
    }

    private fun updateItem(){
        val firstName = editTextFirstName.text.toString()
        val lastName = editTextLastName.text.toString()
        val age = editTextAge.text

        if(checkInput(firstName,lastName,age))
        {
            val user = User(args.currentUser.id,
                firstName,
                lastName,
                Integer.parseInt(age.toString()))

            mUserViewModel.updateUser(user)

            Toast.makeText(requireContext(),"Updated successfully",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else
        {

            Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
        }

    }

    private fun checkInput(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }



    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("yes"){_,_->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(),"Deleted successfully",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }
        builder.setNegativeButton("NO"){_,_->

        }
        builder.setTitle("Delete ${args.currentUser.firstName}")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}")

        builder.show()
    }


}