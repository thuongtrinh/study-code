/* eslint-disable no-undef */

import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
// import { withRouter } from 'react-router-dom'
import { loadUser, loadStarred } from '../actions'
import User from '../components/User'
import Repo from '../components/Repo'
import List from '../components/List'
import zip from 'lodash/zip'
import { withRouter } from '../middleware/withRouter'

const loadData = ({ login, loadUser, loadStarred }) => {
  loadUser(login, ['name'])
  loadStarred(login)
}

class UserPage extends Component {
  static propTypes = {
    login: PropTypes.string.isRequired,
    user: PropTypes.object,
    starredPagination: PropTypes.object,
    starredRepos: PropTypes.array.isRequired,
    starredRepoOwners: PropTypes.array.isRequired,
    loadUser: PropTypes.func.isRequired,
    loadStarred: PropTypes.func.isRequired
  }

  componentDidMount() {
    loadData(this.props)
  }

  componentDidUpdate(prevProps) {
    if (prevProps.login !== this.props.login) {
      loadData(this.props)
    }
  }

  handleLoadMoreClick = () => {
    this.props.loadStarred(this.props.login, true)
  }

  renderRepo([repo, owner]) {
    return <Repo repo={repo} owner={owner} key={repo.fullName} />
  }

  render() {
    const { user, login } = this.props
    if (!user) {
      return (
        <h1>
          <i>
            Loading {login}
            {"'s profile..."}
          </i>
        </h1>
      )
    }

    const { starredRepos, starredRepoOwners, starredPagination } = this.props
    return (
      <div>
        <User user={user} />
        <hr />
        <List
          renderItem={this.renderRepo}
          items={zip(starredRepos, starredRepoOwners)}
          onLoadMoreClick={this.handleLoadMoreClick}
          loadingLabel={`Loading ${login}'s starred...`}
          {...starredPagination}
        />
      </div>
    )
  }
}

const mapStateToProps = (state, ownProps) => {
  // We need to lower case the login due to the way GitHub's API behaves.
  // Have a look at ../middleware/api.js for more details.
  const login = ownProps.match.params.login.toLowerCase()

  const {
    pagination: { starredByUser },
    entities: { users, repos }
  } = state

  const starredPagination = starredByUser[login] || { ids: [] }
  const starredRepos = starredPagination.ids.map(id => repos[id])
  const starredRepoOwners = starredRepos.map(repo => users[repo.owner])

  return {
    login,
    starredRepos,
    starredRepoOwners,
    starredPagination,
    user: users[login]
  }
}

export default withRouter(
  connect(mapStateToProps, {
    loadUser,
    loadStarred
  })(UserPage)
)
