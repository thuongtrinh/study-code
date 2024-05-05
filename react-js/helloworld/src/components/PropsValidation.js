import { Component, Fragment } from 'react';
import PropTypes from 'prop-types';
import IPhonePropsValdidation from './IPhonePropsValdidation';

class PropsValidation extends Component {
    render() {
        const {number1, number2} = this.props
        return (
            <Fragment>
                <p>--------------PropsValdidation------------------ </p>
                <div>{number1} + {number2} = {number1 + number2}</div>
                <p>-------------------------------- </p>
                <IPhonePropsValdidation/>
            </Fragment>
        );
    }
}

PropsValidation.defaultProps = {
    number1: 4,
    number2: 3
}

PropsValidation.propTypes = {
    number1: PropTypes.number,
    number2: PropTypes.number
}

export default PropsValidation;